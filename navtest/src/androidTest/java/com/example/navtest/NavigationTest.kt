package com.example.navtest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)



    @Test
    fun testButtons() {
        onView(withId(R.id.fragment1))
            .check(matches(isDisplayed()))
        checkBnToSecond()
        checkBnToFirst()
        onView(withId(R.id.bnToSecond))
            .perform(ViewActions.click())
        checkBnToThird()
        checkBnToSecond()
        onView(withId(R.id.bnToThird))
            .perform(ViewActions.click())
        checkBnToFirst()
    }

    @Test
    fun testAbout() {
        onView(withId(R.id.fragment1))
            .check(matches(isDisplayed()))
        aboutFromFirst()
        onView(withId(R.id.bnToSecond))
            .perform(ViewActions.click())
        aboutFromSecond()
        onView(withId(R.id.bnToThird))
            .perform(ViewActions.click())
        aboutFromThird()
    }
}