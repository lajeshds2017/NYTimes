package com.newyorktimes.newsapp.view.activity


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import android.support.test.espresso.matcher.ViewMatchers.withClassName
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.view.ViewGroup
import com.newyorktimes.newsapp.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.support.test.InstrumentationRegistry
import android.support.test.uiautomator.UiDevice



@LargeTest
@RunWith(AndroidJUnit4::class)
class NyTimesTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun nyTimesTest() {
        val recyclerView = onView(
            allOf(
                withId(R.id.recyclerView),
                childAtPosition(
                    withClassName(`is`("android.widget.RelativeLayout")),
                    1
                )
            )
        )

        Thread.sleep(5000)
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(0, click()))

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(700)

        val mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        mDevice.pressBack()

        Thread.sleep(2000)

        val recyclerView2 = onView(
            allOf(
                withId(R.id.recyclerView),
                childAtPosition(
                    withClassName(`is`("android.widget.RelativeLayout")),
                    1
                )
            )
        )
        recyclerView2.perform(actionOnItemAtPosition<ViewHolder>(7, click()))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
