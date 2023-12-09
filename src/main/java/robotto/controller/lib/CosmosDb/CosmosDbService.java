package robotto.controller.lib.CosmosDb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.azure.cosmos.ConsistencyLevel;
import com.azure.cosmos.CosmosAsyncClient;
import com.azure.cosmos.CosmosAsyncContainer;
import com.azure.cosmos.CosmosAsyncDatabase;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.models.CosmosContainerProperties;
import com.azure.cosmos.models.CosmosContainerResponse;
import com.azure.cosmos.models.CosmosDatabaseResponse;
import com.azure.cosmos.models.CosmosItemRequestOptions;
import com.azure.cosmos.models.ThroughputProperties;

import reactor.core.publisher.Mono;
import robotto.controller.lib.Models.CosmosDb.Mission;
import robotto.controller.lib.Models.CosmosDb.ResourceMetadata;

@Service
public class CosmosDbService {
    
    private CosmosAsyncClient client;

    private CosmosAsyncDatabase database;

    private CosmosAsyncContainer resourceContainer;

    private CosmosAsyncContainer missionContainer;
    
    @Value("${azure.storage.cosmos.account-key}")
    private String accountKey;

    @Value("${azure.storage.cosmos.endpoint}")
    private String cosmosEndpoint;

    @Value("${azure.storage.cosmos.database-name}")
    private String databaseName;

    @Value("${azure.storage.cosmos.resource-container-name}")
    private String resourceContainerName;

    @Value("${azure.storage.cosmos.mission-container-name}")
    private String missionContainerName;

    private static Logger logger = LogManager.getLogger(CosmosDbService.class.toString());

    public CosmosDbService(){
        // this.client = new CosmosClientBuilder()
        //         .endpoint(cosmosEndpoint)
        //         .key(accountKey)
        //         .contentResponseOnWriteEnabled(true)
        //         .consistencyLevel(ConsistencyLevel.SESSION)
        //         .buildAsyncClient();
        // createDatabaseIfNotExists();
        // createContainerIfNotExists();
    }

    public void uploadMetadata(ResourceMetadata metadata) {
        resourceContainer.createItem(metadata, new CosmosItemRequestOptions())
                .doOnSuccess((response) -> {
                    logger.info("inserted doc with id: {} to {}", response.getItem().getID(), resourceContainerName);
                })
                .doOnError((exception) -> {
                    logger.error(
                            "Exception. e: {}",
                            exception.getLocalizedMessage(),
                            exception);
                }).subscribe();
    }

    public void createMission(Mission mission) {
        missionContainer.createItem(mission, new CosmosItemRequestOptions())
                .doOnSuccess((response) -> {
                    logger.info("inserted doc with id: {} to {}", response.getItem().getID(), missionContainerName);
                })
                .doOnError((exception) -> {
                    logger.error(
                            "Exception. e: {}",
                            exception.getLocalizedMessage(),
                            exception);
                }).subscribe();
    }

    private void createDatabaseIfNotExists(){
        logger.info("Create database " + databaseName + " if not exists.");

        //  Create database if not exists
        Mono<CosmosDatabaseResponse> databaseIfNotExists = client.createDatabaseIfNotExists(databaseName);
        databaseIfNotExists.flatMap(databaseResponse -> {
            database = client.getDatabase(databaseResponse.getProperties().getId());
            logger.info("Checking database " + database.getId() + " completed!\n");
            return Mono.empty();
        }).block();
    }

    private void createContainerIfNotExists(){
        logger.info("Create container {} if not exists.", resourceContainerName);

        CosmosContainerProperties resourceContainerProperties =
                new CosmosContainerProperties(resourceContainerName, "/missionId");

        CosmosContainerProperties missionContainerProperties =
                new CosmosContainerProperties(missionContainerName, "/ID");
        // Provision throughput
        ThroughputProperties throughputProperties = ThroughputProperties.createManualThroughput(400);

        //  Create container with 200 RU/s
        database.createContainerIfNotExists(resourceContainerProperties, throughputProperties).block();
        database.createContainerIfNotExists(missionContainerProperties, throughputProperties).block();
        
    }
}