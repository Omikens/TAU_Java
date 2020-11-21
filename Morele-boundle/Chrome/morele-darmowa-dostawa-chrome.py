from selenium import webdriver
import logging

from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.wait import WebDriverWait

logger = logging.getLogger('Lab2 TAU')
logger.setLevel(logging.INFO)
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)


driver = webdriver.Chrome(executable_path='C:\Program Files (x86)\Google\Chrome\chromedriver.exe')

driver.get('https://www.morele.net/')
logger.info("Opening https://www.morele.net/...")

driver.maximize_window()

account = driver.find_element_by_xpath("/html/body/header/div[1]/div[1]/div/div/div[2]/div/div[2]/div/div[1]/a")
account.click()
logger.info("Opening 'darmowa dostawa' tab")

driver.find_element_by_xpath("/html/body/div[3]/section/section/section[1]/div/div/div[1]/div").click()
logger.info("Clicking button 'zamów z darmową dostawą'")

driver.find_element_by_xpath("/html/body/div[3]/section/section/section[4]/div/div[2]/a[2]").click()
logger.info("Opening 'komputery' tab")

driver.switch_to.window(driver.window_handles[1])

if driver.current_url == "https://www.morele.net/komputery/":
    logger.info("Test was completed successfuly")
else:
    logger.critical("Current url is not correct")

driver.close()