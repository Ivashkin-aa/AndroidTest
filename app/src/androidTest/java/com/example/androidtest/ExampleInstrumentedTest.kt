package com.example.androidtest


import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.CoreMatchers.not
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    var mainActivity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkVid() {
        onView(withId(R.id.edittext))
            .check(matches(isDisplayed()))
        onView(withId(R.id.button))
            .check(matches(isDisplayed()))
    }

    @Test
    fun contactWithVid() {
        onView(withId(R.id.button))
            .perform(ViewActions.click())
        onView(withId(R.id.edittext))
            .perform(ViewActions.clearText())
            .perform(ViewActions.typeText("Hello Android"))
        closeSoftKeyboard()

        onView(withId(R.id.button))
            .check(matches(withText(R.string.secondtext)))
        onView(withId(R.id.edittext))
            .check(matches(withText("Hello Android")))

        mainActivity.scenario.recreate()

        onView(withId(R.id.button))
            .check(matches(not(withText(R.string.secondtext))))
            .check(matches(withText(R.string.firsttext)))
        onView(withId(R.id.edittext))
            .check(matches(withText("Hello Android")))

    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.androidtest", appContext.packageName)
    }
}

