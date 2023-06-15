Feature: Movie

    Test The One API service calling movie

#    Scenario: User call movie endpoint
#        Given user call get "movie" endpoint
#        When response is 200
#        And list size is 8
#        Then name is "The Lord of the Rings Series"

    Scenario Outline: User call all movie endpoints
        Given user call get "movie" endpoint
        When response is 200
        And list size is 8
        Then name is "<name>"
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
