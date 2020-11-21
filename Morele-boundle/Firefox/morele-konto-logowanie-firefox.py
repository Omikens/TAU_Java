from selenium import webdriver
import logging


class WrongEmail:
    logger = logging.getLogger('Lab2 TAU')
    logger.setLevel(logging.INFO)
    ch = logging.StreamHandler()
    ch.setLevel(logging.DEBUG)
    formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
    ch.setFormatter(formatter)
    logger.addHandler(ch)

    driver = webdriver.Firefox(executable_path='C:\Program Files\Mozilla Firefox\geckodriver.exe')

    driver.get('https://www.morele.net/')
    logger.info("Opening https://www.morele.net/...")

    driver.maximize_window()

    account = driver.find_element_by_class_name("icon-user")
    account.click()
    logger.info("Opening login tab...")

    username = driver.find_element_by_id("username")
    username.click()
    username.send_keys("Test")
    logger.info("Input wrong email...")

    password = driver.find_element_by_id("password-log")
    password.click()
    password.send_keys("123456")
    logger.info("Input test password...")

    driver.find_element_by_xpath("/html/body/main/div/div/div[3]/form/button").click()
    logger.info("Trying to login...")

    try:
        driver.find_elements_by_class_name("form-control-error")
        logger.info("Test was completed successfuly")
    except:
        logger.critical("Could not find error message")

    driver.close()