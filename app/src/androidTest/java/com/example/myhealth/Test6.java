package com.example.myhealth;


import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class Test6 {

    @Rule
    public ActivityTestRule<DetailsActivity> mActivityTestRule = new ActivityTestRule<>(DetailsActivity.class);

    @Test
    public void test6() {
        onView(withId(R.id.txtWeight)).perform(typeText("0"));
        onView(withId(R.id.txtHeight)).perform(typeText("0"), closeSoftKeyboard());

        onView(withId(R.id.btnCalculateBMI)).perform(click());
        onView(withText("Error")).check(matches(isDisplayed()));
    }

}
