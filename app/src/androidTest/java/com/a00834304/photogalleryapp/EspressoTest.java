package com.a00834304.photogalleryapp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class EspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void getToSearchPage() {
        onView(withId(R.id.imgSearch)).perform(click());
        onView(withId(R.id.btnDate)).perform(click());
    }

    @Test
    public void testSearchByDate() {
        // Type a good date and press search button
        onView(withId(R.id.editDate)).perform(typeText("2017-10-01"), closeSoftKeyboard());
        onView(withId(R.id.btnSearch)).perform(click());

        // Check if the image shows
        onView(withId(R.id.imgResult)).check(matches(withDrawable(R.drawable.tn03)));

        // Type a bad date and press search button
        onView(withId(R.id.editDate)).perform(typeText("2017-11-01"), closeSoftKeyboard());
        onView(withId(R.id.btnSearch)).perform(click());

        // Check if the image shows
        onView(withId(R.id.imgResult)).check(matches(withDrawable(R.drawable.blank)));
    }

    public static Matcher<View> withDrawable(final int resourceId) {
        return new DrawableMatcher(resourceId);
    }
/*    @Test
    public void ensureTextChangesWork() {
        // Type text and then press the button.
        onView(withId(R.id.edit_message))
                .perform(typeText("HELLO"), closeSoftKeyboard());
        onView(withId(R.id.send_message)).perform(click());
        // Check that the text was changed.
        onView(withId(R.id.test_message)).check(matches(withText("HELLO")));
        //onView(withContentDescription("Navigate up")).perform(click());
    }*/
}