package robotto.controller.lib;

import robotto.controller.lib.BlobStorage.Interfaces.BlobStorageService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        // Initialize necessary components
        BlobStorageService blobStorageService = new BlobStorageServiceImpl(); // Initialize BlobStorageService implementation
        /* 
        String missionId = "123"; // Example mission ID
        Resource resource = new Resource(); // Example resource object
        
        int resourceId = blobStorageService.uploadResource(missionId, resource);
        */

        System.out.println( "Hello World!" );

        if (resourceId != -1) {
            System.out.println("Resource uploaded successfully with ID: " + resourceId);
        } else {
            System.out.println("Failed to upload the resource.");
        }
    }
}
