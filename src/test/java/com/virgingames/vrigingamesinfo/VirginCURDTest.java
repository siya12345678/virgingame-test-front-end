package com.virgingames.vrigingamesinfo;

import com.virgingames.virgingamesinfo.VirginGamesSteps;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@RunWith(SerenityRunner.class)
public class VirginCURDTest { static String startTime;
    static String timeStamp;
    static String defaultGameFrequency;


    @Steps
    VirginGamesSteps virginGamesSteps;

    @Title("This test will get all Games Frequency = 300000")
    @Test
    public void test001() {


        ValidatableResponse response = virginGamesSteps.getAllRecord().statusCode(200);
        defaultGameFrequency = response.extract().path("bingoLobbyInfoResource.streams.findAll{it.defaultGameFrequency='300000'}.defaultGameFrequency").toString();
        Assert.assertTrue(defaultGameFrequency.contains("300000"));
        System.out.println("Frequency are : " + defaultGameFrequency);

    }

    @Title("This test will get future timestamp")
    @Test
    public void test002() {
        ValidatableResponse response = virginGamesSteps.getAllRecord().statusCode(200);
        timeStamp = response.extract().response().body().path("timestamp").toString();
        startTime = response.extract().response().body().path("bingoLobbyInfoResource.streams.startTime").toString();
        System.out.println("Timestamp is : " + timeStamp);
        System.out.println("StartTime is : " + startTime);
        assertThat(startTime, greaterThan(timeStamp));
    }
}
