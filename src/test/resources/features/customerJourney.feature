Feature: customer Journey and Journey stage

#  @uiTest
#  Scenario: Verify the user can login and check the options displayed properly
#    Given user opened the register website
#    When the user logged in with credentials
#    Then user verifies the options displayed expected

  @apiTest
  Scenario: Verify customer Journey and Journey stage
    Given user sent the post request setting the channel "Web" and container name as "DomainConfigGBBUpsellMain"
    Then I should get the customer Journey and Journey stage report



#  @apiTestCallCenter
#  Scenario Outline: Verify the user posting PRRestService container responds
#    Given user sets the context for PRRestService amd headers ahgdas
#    When user sent the post request setting the channel "CallCenter" and container name as "InCart" and "<rowNumber>"
##    Then the response contains container name "InCart" and channel is "CallCenter"
###    Given user sets the context for webCapture Service and headers
###    And user sent post capture request to the channel "Web" and container name as "InCart" and "<rowNumber>"
###    Then the capture response should contain journey and journey stage
#    Examples:
#      | rowNumber |
#      | 1         |
##      | 2         |
##      | 3         |
##      | 4         |
##      | 5         |
##


