/**
 * Copyright Microsoft Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.microsoft.windowsazure.management;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.microsoft.windowsazure.management.models.LocationsListResponse;

public class LocationOperationsTest extends ManagementIntegrationTestBase {

    @BeforeClass
    public static void setup() throws Exception {
        createService();
    }
    
    @Before
    public void beforeTest() throws Exception {
        setupTest();
    }
    
    @After
    public void afterTest() throws Exception {
        resetTest();
    }
    
    @Test
    public void listLocationSuccess() throws Exception {
        LocationsListResponse locationsListResponse = managementClient.getLocationsOperations().list();
        Assert.assertEquals(200, locationsListResponse.getStatusCode());
        Assert.assertNotNull(locationsListResponse.getRequestId());
        Assert.assertTrue(locationsListResponse.getLocations().size() > 0);
    }
}