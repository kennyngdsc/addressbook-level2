package seedu.addressbook.data.person;

public class Block {
	
	private final String block;
	
	public Block(String block) {
		this.block = block;
	}
	
	public String getBlock() {
		return block;
	}
	
	@Override
    public String toString() {
        return "BLOCK " + block;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.block.equals(((Block) other).block)); // state check
    }
}
