package seedu.addressbook.data.person;

public class PostalCode {

	private final String postalCode;
	
	public PostalCode(String code) {
		this.postalCode = code;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	@Override
    public String toString() {
        return "SINGAPORE(" + postalCode + ")";
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && this.postalCode.equals(((PostalCode) other).postalCode)); // state check
    }
}
