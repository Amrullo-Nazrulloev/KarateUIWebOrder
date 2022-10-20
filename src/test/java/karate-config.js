function fn() {
  var env = karate.env; // get system property 'karate.env'
  karate.log('karate.env system property was:', env);
  if (!env) {
    env = 'dev';
  }
  var config = {
    env: env,
    browser: 'chrome',
    ChromePath:'C:/Program Files/Google/Chrome/Application/chrome.exe',
    UserName:'Tester',
    password:'test',
    url:'http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx',
  }




  if (env == 'dev') {
  config.url='http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx';
  config.driverConfig = read('classpath:Utilities/browserCapabilities.json');

  } else if (env == 'e2e') {
    // customize
  }
  return config;
}