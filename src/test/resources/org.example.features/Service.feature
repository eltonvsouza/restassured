Feature: Service

    Test The One API service

    Scenario: User call movie endpoint without authorization
        Given user call endpoint without auth
        When response is 401
        Then message is "Unauthorized."

    Scenario: User call invalid endpoint
        Given user call get invalid endpoint
        When response is 404
        Then validate error message "Endpoint does not exist."

