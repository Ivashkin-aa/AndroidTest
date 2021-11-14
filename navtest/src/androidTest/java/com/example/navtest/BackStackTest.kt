package com.example.navtest

import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BackStackTest {

    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun firstTest() {
        onView(withId(R.id.fragment1))
            .check(matches(isDisplayed()))
        checkBnToSecond()
        checkBnToFirst()
        pressBackUnconditionally()
        assertTrue(activity.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun secondTest() {
        onView(withId(R.id.fragment1))
            .check(matches(isDisplayed()))
        checkBnToSecond()
        checkBnToThird()
        checkBnToSecond()
        pressBack()
        onView(withId(R.id.fragment1))
            .check(matches(isDisplayed()))
        checkBnToSecond()
        checkBnToThird()
        checkBnToFirst()
        pressBackUnconditionally()
        assertTrue(activity.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun thirdTest() {
        onView(withId(R.id.fragment1))
            .check(matches(isDisplayed()))
        aboutFromFirst()
        checkBnToSecond()
        aboutFromSecond()
        checkBnToThird()
        aboutFromThird()
    }
}