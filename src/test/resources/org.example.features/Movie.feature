Feature: Movie

    Test The One API service calling movie

    Scenario: User call movie endpoint without authorization
        Given user call endpoint without auth
        When response is 401
        Then message is "Unauthorized."

    Scenario: User call invalid endpoint
        Given user call get invalid endpoint
        When response is 404
        Then validate error message "Endpoint does not exist."

    Scenario: User call movie endpoint
        Given user call get movie endpoint
        When response is 200
        Then movie name is "The Lord of the Rings Series"

    Scenario Outline: User call all movie endpoint
        Given user call get movie endpoint
        When response is 200
        Then movie name is "<name>"
        Examples:
            | name                          |
            | The Lord of the Rings Series  |
            | The Hobbit Series             |
            | The Unexpected Journey        |
            | The Desolation of Smaug       |
            | The Battle of the Five Armies |
            | The Two Towers                |
            | The Fellowship of the Ring    |
            | The Return of the King        |
