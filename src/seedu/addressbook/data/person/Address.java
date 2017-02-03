package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;
    // public final String value;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        // this.value = trimmedAddress;
        
        String[] segmentedAddress = trimmedAddress.split(",");
        this.block = new Block(segmentedAddress[0]);
        this.street = new Street(segmentedAddress[1]);
        this.unit = new Unit(segmentedAddress[2]);
        this.postalCode = new PostalCode(segmentedAddress[3]);
        // this.value = block.getBlock() + "," + street.getStreet() + "," + unit.getUnit() + "," + postalCode.getPostalCode();
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return block + ", " + street + ", " + unit + ", " + postalCode;
    }

    @Override
    public boolean equals(Object other) {
    	if (!(other instanceof Address)) {
    		return false;
    	}
    	Address otherCopy = (Address) other;
    	return otherCopy.getBlock().equals(block) &&
    			otherCopy.getStreet().equals(street) &&
    			otherCopy.getUnit().equals(unit) &&
    			otherCopy.getPostalCode().equals(postalCode);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
