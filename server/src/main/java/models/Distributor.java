package models;

import java.util.ArrayList;
import java.util.List;

public class Distributor {
    private String name;
    private List<Item> items;

    public Distributor(String name) {
        this.name = name;

        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public double getCheapestCost(String itemName) {
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                return item.getCost();
            }
        }
        // doesn't exist in vendor
        return Double.MAX_VALUE;
    }
    // TODO: name, id, cost
    public Boolean isItemInDistributorByName(String name)
    {
        for (int i = 0; i < items.size(); i++)
        {
            if (items.get(i).getName() == name)
                return true;
        }

        return false;
    }

    public Boolean isItemInDistributorById(int id)
    {
        for (int i = 0; i < items.size(); i++)
        {
            if (items.get(i).getId() == id)
                return true;
        }

        return false;
    }

    public Boolean isItemInDistributorByCost(double cost)
    {
        for (int i = 0; i < items.size(); i++)
        {
            if (items.get(i).getCost() == cost)
                return true;
        }

        return false;
    }

    public int getTotalItems()
    {
        return items.size();
    }
}
