package org.ligi.android.common.preferences;

import android.content.Context;
import android.preference.EditTextPreference;
import android.util.AttributeSet;
/**
 * a Preference to edit a integer !Warning untested!
 *
 * @author ligi ( aka: Marcus Bueschleb | mail: ligi at ligi dot de )
 *
 * License: GPLv3
 */
public class EditIntegerPreference extends EditTextPreference
{
  public EditIntegerPreference(Context context)
  {
    super(context);
  }

  public EditIntegerPreference(Context context, AttributeSet attrs)
  {
    super(context, attrs);
  }

  public EditIntegerPreference(Context context, AttributeSet attrs, int defStyle)
  {
    super(context, attrs, defStyle);
  }

  @Override
  public String getText()
  {
    return String.valueOf(getSharedPreferences().getInt(getKey(), 0));
  }

  @Override
  public void setText(String text)
  {
	  getSharedPreferences().edit().putInt(getKey(),Integer.parseInt(text))
      .commit();
  }
}