package preferences.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PreferencesController {

	@Autowired
	PreferencesRepository preferencesRepository;

	@GetMapping("/preferences")
	public Iterable<Preferences> getAllPreferences() {
		return preferencesRepository.findAll();
	}

	@PostMapping("/preferences")
	public Preferences createPreferences(@Valid @RequestBody Preferences preferences) {
		return preferencesRepository.save(preferences);
	}

	@GetMapping(value = "/preferences/{uid}")
	public ResponseEntity<List> getPreferencesByUser(@PathVariable("uid") String uid) {
		List<Preferences> preferencesData = preferencesRepository.findByUid(uid);
		if (preferencesData == null||preferencesData.isEmpty()) {
			return new ResponseEntity<List>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List>(preferencesData, HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/preferences/{uid}/{key}")
	public ResponseEntity<Preferences> getPreferencesByUserAndKey(@PathVariable("uid") String uid, @PathVariable("key") String key) {
		Preferences preferencesData = preferencesRepository.findByUidAndKey(uid, key);
		if (preferencesData == null) {
			return new ResponseEntity<Preferences>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Preferences>(preferencesData, HttpStatus.OK);
		}
	}

	
	@PutMapping(value = "/preferences/{uid}/{key}")
	public ResponseEntity<Preferences> updatePreferencesForUser(@PathVariable("uid") String uid, @PathVariable("key") String key, @Valid @RequestBody Preferences preferences) {
		Preferences preferencesData = preferencesRepository.findByUidAndKey(uid, key);
		if (preferencesData == null) {
			return new ResponseEntity<Preferences>(HttpStatus.NOT_FOUND);
		}
		preferencesData.setValue(preferences.getValue());
		preferencesRepository.save(preferencesData);
		return new ResponseEntity<Preferences>(HttpStatus.OK);
	}

}
