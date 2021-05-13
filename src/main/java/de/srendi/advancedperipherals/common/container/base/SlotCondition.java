package de.srendi.advancedperipherals.common.container.base;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ITag;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is required by {@link SlotInputHandler} to define which item is valid for the slot.
 */
public class SlotCondition {

    public List<ITag.INamedTag> neededTags = new ArrayList<>();

    public List<Item> neededItems = new ArrayList<>();

    /**
     * Sets the valid tags for the item
     *
     * @param neededTags the tags which the item should have
     * @return the current instance
     */
    public SlotCondition setNeededTags(List<ITag.INamedTag> neededTags) {
        this.neededTags = neededTags;
        return this;
    }

    /**
     * Sets the valid items for the slot
     *
     * @param neededItems the items which the item should be
     * @return the current instance
     */
    public SlotCondition setNeededItems(List<Item> neededItems) {
        this.neededItems = neededItems;
        return this;
    }

    /**
     * Sets the valid item for the slot
     *
     * @param item the item which the item should be
     * @return the current instance
     */
    public SlotCondition setNeededItem(Item item) {
        neededItems.clear();
        neededItems.add(item);
        return this;
    }

    /**
     * Sets the valid tag for the item
     *
     * @param tag the tag which the item should have
     * @return the current instance
     */
    public SlotCondition setNeededTag(ITag.INamedTag tag) {
        neededTags.clear();
        neededTags.add(tag);
        return this;
    }

    /**
     * Checks if the stack is valid for the tags/items. Used in {@link SlotInputHandler}
     *
     * @param stack the {@link ItemStack} which needs to be checked
     * @return returns true if the item is valid
     */
    public boolean isValid(ItemStack stack) {
        boolean valid = true;
        if (!neededTags.isEmpty()) {
            for (ITag.INamedTag tag : neededTags) {
                if (!stack.getItem().getTags().contains(tag.getName()))
                    valid = false;
            }
        }
        if (!neededItems.isEmpty()) {
            if (!neededItems.contains(stack.getItem()))
                valid = false;
        }
        return valid;
    }

}
