from selenium import webdriver
import logging

logger = logging.getLogger('Lab2 TAU')
logger.setLevel(logging.INFO)
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)

driver = webdriver.Firefox(executable_path='C:\Program Files\Mozilla Firefox\geckodriver.exe')

driver.get('http://www.gral.pl/')
logger.info("Opening http://www.gral.pl/...")

temp = driver.find_element_by_id("identmenu122")
temp.click()
logger.info("Opening tab 'Obudowy'...")

xpath = "/html/body/table[5]/tbody/tr/td[2]/table[2]/tbody/tr[1]/td[1]/table/tbody/tr/td[1]/table/tbody/tr[5]/td/table/tbody/tr/td[2]/div/form/button"
try:
    driver.find_element_by_xpath(xpath).click()
    logger.info("Adding to cart: 'Modecom Oberon Pro LE USB 3.0'...")
except:
    logger.warning("Problem with getting element: 'add to cart button'")

temp = driver.find_element_by_id("identmenu122")
temp.click()
logger.info("Opening tab 'Obudowy'...")

try:
    driver.find_element_by_xpath(xpath).click()
    logger.info("Adding to cart: 'Modecom Oberon Pro LE USB 3.0'...")
except:
    logger.warning("Problem with getting element: 'add to cart button'")

temp = driver.find_element_by_id("ilek1")
orderCount = temp.get_attribute("value")

logger.info('Checking if number of items in cart is correct...')

if int(orderCount) == 2:
    logger.info('Test was completed successfuly')
else:
    logger.error('Expected value = 2 instead got: ', int(orderCount))

driver.close()
