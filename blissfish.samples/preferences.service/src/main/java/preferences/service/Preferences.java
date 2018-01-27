package preferences.service;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Preferences {

		@Id
	    private String id;
		private String uid;
	    private String key;
	    private String value;
	    
	    public Preferences() {
		}
	    
	    public Preferences(String id, String uid, String key, String value) {
	        this.id = id;
	        this.uid = uid;
	        this.key = key;
	        this.value = value;
	    }
	    
	    public void setId(String id) {
			this.id = id;
		}

		public void setUid(String uid) {
			this.uid = uid;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public void setValue(String value) {
			this.value = value;
		}

	    public String getId() {
			return id;
		}

		public String getUid() {
			return uid;
		}

		public String getKey() {
			return key;
		}

		public String getValue() {
			return value;
		}

		@Override
	    public String toString() {
	        return String.format(
	                "Preferences[id=%s,uid='%s', key='%s'],value='%s'",
	                id, uid, key, value);
	    }

	}