Feature: Book

    Test The One API service calling book

#    Scenario: User call book endpoint
#        Given user call get "book" endpoint
#        When response is 200
#        And list size is 3
#        Then name is "The Fellowship Of The Ring"

    Scenario Outline: User call all book endpoints
        Given user call get "book" endpoint
        When response is 200
        And list size is 3
        Then name is "<name>"
        Examples:
            | name                       |
            | The Fellowship Of The Ring |
            | The Two Towers             |
            | The Return Of The King     |
