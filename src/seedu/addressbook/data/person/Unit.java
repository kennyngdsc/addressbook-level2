package seedu.addressbook.data.person;

public class Unit {
	
	private final String unit;
	
	public Unit(String unit) {
		this.unit = unit;
	}
	
	public String getUnit() {
		return unit;
	}
	
	@Override
    public String toString() {
        return "UNIT " + unit;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && this.unit.equals(((Unit) other).unit)); // state check
    }
}
