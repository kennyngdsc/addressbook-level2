package seedu.addressbook.data.tag;
import seedu.addressbook.data.person.Person;

public class Tagging {
	
	public static final String STATE_ADD_TAG = "+";
	public static final String STATE_REMOVE_TAG = "-";
	
	private Tag tag;
	private Person contact;
	private String state;
	
	public Tagging(Tag tag, Person contact, String state) {
		this.tag = tag;
		this.contact = contact;
		this.state = state;
	}
	
	@Override
	public String toString(){
		switch(state){
			case STATE_ADD_TAG:
				return STATE_ADD_TAG + " " + contact.getName() + " " + tag.toString();
			case STATE_REMOVE_TAG:
	            return STATE_REMOVE_TAG + " " + contact.getName() + " " + tag.toString();
	        default:
	            return "INVALID_STRING";
		}
	}
	
}
