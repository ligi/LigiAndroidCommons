package org.ligi.android.common.preferences;

import java.util.Vector;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;

/**
 * Class to enable or disable preferences depending on the state of a CheckBoxPrefenece
 * If somebody has a idea for a better name for this class just let me know ;-) 
 * 
 * usage:
 *  you construct this class with a CheckBoxPreference and then add the Preferences  
 *  where you want to toggle enable/disable depending on the CheckBox 
 *  via addPreference2SetEnable(Preference p)
 * 
 * @author ligi ( aka: Marcus Bueschleb | mail: ligi at ligi dot de )
 *
 * License: GPLv3
 */
public class SetPreferenceEnabledByCheckBoxPreferenceState implements OnPreferenceChangeListener {

	private Vector<Preference> preference_vector;
	private CheckBoxPreference pref;
	
	public SetPreferenceEnabledByCheckBoxPreferenceState(CheckBoxPreference pref) {
		this.pref=pref;
		pref.setOnPreferenceChangeListener(this);
		preference_vector=new Vector<Preference>();
	}
	
	public SetPreferenceEnabledByCheckBoxPreferenceState addPreference2SetEnable(Preference new_p) {
		preference_vector.add(new_p);
		new_p.setEnabled(pref.isChecked());
		return this;
	}
	
	public boolean onPreferenceChange(Preference preference, Object newValue) {
		for (Preference p : preference_vector)
			p.setEnabled((Boolean)newValue);
		return true;
	}
	
}
