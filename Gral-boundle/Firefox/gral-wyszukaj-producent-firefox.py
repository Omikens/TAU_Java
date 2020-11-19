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

search = driver.find_element_by_id("szukaj01")
search.click()
search.send_keys("Spartan")
logger.info("Searching for 'Spartan'...")

try:
    driver.find_element_by_xpath("/html/body/table[3]/tbody/tr[1]/td[1]/form/table/tbody/tr/td[3]/select/option[114]").click()
    logger.info("Searching for manufacturer 'SilentiumPC'...")
except:
    logger.error("Unable to find desired element")

driver.find_element_by_name("bks33222").click()
logger.info("Initiate searching...")
logger.info("Checking if search results contain desired items...")
try:
    driver.find_element_by_partial_link_text('Spartan')
except:
    logger.critical("Unable to find link to: http://www.gral.pl/SilentiumPC+Spartan+3+LT+HE1012_179.html")
else:
    logger.info("Test was completed successfuly")

driver.close()
