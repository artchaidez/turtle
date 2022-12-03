package models;

import autoFramework.AutoBase;

public class Models extends AutoBase {

    public Distributor distributor;
    public Distributors distributors;
    public Inventory inventory;
    public Item item;

    public Models()
    {
        //distributor = new Distributor();
        distributors = new Distributors();
        inventory = new Inventory();
        //item = new Item();
    }
}
