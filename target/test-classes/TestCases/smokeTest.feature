@smoke

Feature: WebOrder - Automation SmokeTest

  Background:
    * call read('classpath:OrderWeb/common/login.feature')
    * call read 'classpath:OrderWeb/PageObjects/locators.json'

  Scenario: WebOrder - Automation Smoke Test

    Given def Step1 = "Log into WebOrder using provided credentials"
    When  def Step2 = "Select check all button from list of all orders"
    * click(ListOfAllOrders.CheckAllBtn).delay(100)
    * click(ListOfAllOrders.DeleteAllBtn)

