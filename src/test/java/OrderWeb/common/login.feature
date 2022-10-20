Feature: WebOrder Login
  I want to use this template for all my features

  Background:
    * call read 'classpath:OrderWeb/PageObjects/locators.json'
#    * def driverConfig = { type: '#(browser)', executable: '#(chromePath)', showDriverLog: true, addOptions: [ "--incognito" , "--start-maximized", "--disable-extensions" ,"--dns-prefetch-disable", "--disable-gpu" ,"--dns-prefetch-disable"], webDriverSession: { desiredCapabilities: { browserName: '#(browser)', "goog:chromeOptions": { useAutomationExtension: false } } } }
    * configure driver = driverConfig

  @ignore
  Scenario: WebOrderLogin
    Given driver url
    * retry(10,2000).waitFor(Login.usernameTextbox)
    When input(Login.usernameTextbox,UserName)
    And input(Login.passwordTextbox,password)
    * click(Login.LoginButton).delay(1000)
    Then match driver.title == 'Web Orders'