package preferences.service;

	import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

	@Repository
	public interface PreferencesRepository extends CrudRepository<Preferences, String> {
		List<Preferences> findByUid(String uid);
		Preferences findByUidAndKey(String uid, String key);

	}