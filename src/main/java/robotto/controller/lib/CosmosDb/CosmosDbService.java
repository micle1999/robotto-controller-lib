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
import com.azure.cosmos.models.CosmosDatabaseResponse;
import com.azure.cosmos.models.CosmosItemRequestOptions;

import reactor.core.publisher.Mono;
import robotto.controller.lib.Models.CosmosDb.ResourceMetadata;

@Service
public class CosmosDbService {
    
    private CosmosAsyncClient client;

    private CosmosAsyncDatabase database;

    private CosmosAsyncContainer container;

    @Value("${azure.storage.cosmos.account-name}")
    private String accountName;

    @Value("${azure.storage.cosmos.account-key}")
    private String accountKey;

    @Value("${azure.storage.cosmos-endpoint}")
    private String cosmosEndpoint;

    @Value("${azure.storage.database-name}")
    private String databaseName;

    private static Logger logger = LogManager.getLogger(CosmosDbService.class.toString());

    public CosmosDbService(){
        this.client = new CosmosClientBuilder()
                .endpoint(cosmosEndpoint)
                .key(accountKey)
                .contentResponseOnWriteEnabled(true)
                .consistencyLevel(ConsistencyLevel.SESSION)
                .buildAsyncClient();
        createDatabaseIfNotExists();
        //createContainerIfNotExists();
    }

    public void uploadMetadata(ResourceMetadata metadata) {
        container.createItem(metadata, new CosmosItemRequestOptions())
                .doOnSuccess((response) -> {
                    logger.info("inserted doc with id: {}", response.getItem().getID());
                })
                .doOnError((exception) -> {
                    logger.error(
                            "Exception. e: {}",
                            exception.getLocalizedMessage(),
                            exception);
                }).subscribe();
    }

    private void createDatabaseIfNotExists() {
        logger.info("Create database " + databaseName + " if not exists.");

        //  Create database if not exists
        Mono<CosmosDatabaseResponse> databaseIfNotExists = client.createDatabaseIfNotExists(databaseName);
        databaseIfNotExists.flatMap(databaseResponse -> {
            database = client.getDatabase(databaseResponse.getProperties().getId());
            logger.info("Checking database " + database.getId() + " completed!\n");
            return Mono.empty();
        }).block();
    }
}