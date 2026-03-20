package tests;

import api.UserApiClient;
import io.qameta.allure.*;
import org.testng.annotations.*;
import org.testng.Assert;

import java.io.IOException;

public class E2ETest {

    @Test
    @Description("This test attempt to create a user and confirming the creation of itself by checking the id of the created user")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Sergio Suárez")
    @Story("CreateUser")
    public void testCreateUser() throws IOException, InterruptedException {
        var id = UserApiClient.createUser("Jhon Doe", "Developer");
        if(id == null || id.isEmpty())
            Assert.fail();
        Assert.assertTrue(Integer.parseInt(id) > 0);
    }

    @Test
    @Description("This test attempt to get a specific user")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Sergio Suárez")
    @Story("getUser")
    public void testGetUser() throws IOException, InterruptedException {
        var usrName = UserApiClient.getUser(2);
        if(usrName == null || usrName.isEmpty())
            Assert.fail();
        Assert.assertEquals(usrName, "Janet Weaver");
    }
}
