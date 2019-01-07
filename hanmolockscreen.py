
# -*- coding: utf-8 -*-
import os
import unittest
from time import sleep

from appium import webdriver
from appium.webdriver.common.touch_action import TouchAction


class hanmolockscreen(unittest.TestCase):


    def setUp(self):
   # Setup for the test
        desired_caps = {}
        desired_caps['platformName'] = 'Android'
        desired_caps['platformVersion'] = '8.0'
        desired_caps['deviceName'] = 'test'
        # Returns abs path relative to this file and not cwd
        desired_caps['app'] = os.path.abspath(os.path.join(os.path.dirname(__file__), '/Users/password_specup/Desktop/LockScreenKotlinExample/app/build/outputs/apk/debug/app-debug.apk'))
        desired_caps['appPackage'] = 'com.lockscreen.hanmo.lockscreenkotlinexample'
        #desired_caps['appActivity'] = 'com.lockscreen.hanmo.lockscreenkotlinexample.MainActivity'
        self.driver = webdriver.Remote('http://localhost:4723/wd/hub', desired_caps)

    def tearDown(self):
      # "Tear down the test"
       self.driver.quit()

    """ def test_lock(self):
        self.driver.lock(-1)
        try :
            self.assertTrue(self.driver.is_locked())
        finally :
            self.driver.unlock()
            self.assertFalse(self.driver.is_locked())"""


    def test_search_field(self):
       #잠금화면 꺼진 상태에서 잠금화면 노출확인
       #잠금화면 꺼진 상태에서 잠금화면 노출확인
        #아이디 공백 입력 후 로그인 버튼 선택


        sleep(1)

       # 잠금화면 켜진 상태에서 잠금화면 노출확인
        startlockscreen = self.driver.find_element_by_id('com.lockscreen.hanmo.lockscreenkotlinexample:id/showLockScreenViewButton')
        startlockscreen.click()
        print('버튼클릭성공')
        sleep(2)

        lockScreenView = self.driver.find_element_by_id('com.lockscreen.hanmo.lockscreenkotlinexample:id/lockScreenView').click()
        self.driver.swipe(62, 1208, 960, 1208, 400)

        self.driver.lock()

        self.driver.unlock()
        sleep(1)
        ttoggle = self.driver.find_element_by_id('com.lockscreen.hanmo.lockscreenkotlinexample:id/lockScreeSwitch')
        ttoggle.click()
        sleep(1)

        startlockscreen = self.driver.find_element_by_id('com.lockscreen.hanmo.lockscreenkotlinexample:id/showLockScreenViewButton')
        startlockscreen.click()
        print('버튼클릭성공')
        sleep(2)

        lockScreenView = self.driver.find_element_by_id('com.lockscreen.hanmo.lockscreenkotlinexample:id/lockScreenView').click()
        self.driver.swipe(62, 1208, 960, 1208, 400)
        sleep(2)


        self.driver.lock(-1)
        sleep(2)
        try :
            self.assertTrue(self.driver.is_locked())
        finally :
            self.driver.unlock()
            self.assertFalse(self.driver.is_locked())
        sleep(2)
        lockScreenView = self.driver.find_element_by_id('com.lockscreen.hanmo.lockscreenkotlinexample:id/lockScreenView').click()
        self.driver.swipe(62, 1208, 960, 1208, 400)
        sleep(3)


        button = self.driver.find_element_by_id('com.lockscreen.hanmo.lockscreenkotlinexample:id/btn_request_permission')
        button.click()
        print('버튼클릭성공')
        sleep(2)


# ---START OF SCRIPT
if __name__ == '__main__':
    suite = unittest.TestLoader().loadTestsFromTestCase(hanmolockscreen)

    unittest.TextTestRunner(verbosity=2).run(suite)