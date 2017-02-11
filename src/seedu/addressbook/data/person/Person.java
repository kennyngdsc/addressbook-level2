package seedu.addressbook.data.person;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.tag.Tagging;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Objects;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Person implements ReadOnlyPerson {

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;

    private final UniqueTagList tags;
    /**
     * Assumption: Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Address address, UniqueTagList tags) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.tags = new UniqueTagList(tags); // protect internal tags from changes in the arg list
    }

    /**
     * Copy constructor.
     */
    public Person(ReadOnlyPerson source) {
        this(source.getName(), source.getPhone(), source.getEmail(), source.getAddress(), source.getTags());
    }

    @Override
    public Name getName() {
        return name;
    }

    @Override
    public Phone getPhone() {
        return phone;
    }

    @Override
    public Email getEmail() {
        return email;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public UniqueTagList getTags() {
        return new UniqueTagList(tags);
    }

    /**
     * Replaces this person's tags with the tags in the argument tag list.
     */
    public void setTags(UniqueTagList replacement) {
        tags.setTags(replacement);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ReadOnlyPerson // instanceof handles nulls
                && this.isSameStateAs((ReadOnlyPerson) other));
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, tags);
    }

    @Override
    public String toString() {
        return getAsTextShowAll();
    }

    public void addTag(String tag) throws IllegalValueException {
    	Tag newTag = new Tag(tag);
    	tags.add(newTag);
    	AddressBook.addTagging(new Tagging(newTag, this, Tagging.STATE_ADD_TAG));
    }
    
    public void removeTag(String tag) throws IllegalValueException, UniqueTagList.TagNotFoundException {
    	for (Tag currentTag: tags) {
    		if (currentTag.tagName == tag) {
    			tags.remove(currentTag);
    			AddressBook.addTagging(new Tagging(new Tag(tag), this, Tagging.STATE_REMOVE_TAG));
    			break;
    		}
    	}
    }
}
