package com.virgingames.virgingamesinfo;

import com.virgingames.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static io.restassured.RestAssured.defaultParser;

public class VirginGamesSteps {
    // This class get All Games Record

    @Step("Get all record of virgin games ")

    public ValidatableResponse getAllRecord() {

        return SerenityRest.rest().given()
                .when()
                .log()
                .all()
                .get(EndPoints.GET_ALL_VIRGIN_GAMES_RECORD)
                .then()

                .parser("text/plain;charset=UTF-8", defaultParser.JSON);
    }
}
