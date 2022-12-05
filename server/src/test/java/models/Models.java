package models;

import autoFramework.AutoBase;

public class Models extends AutoBase {

    public Distributors distributors;
    public Inventory inventory;

    public Models()
    {
        distributors = new Distributors();
        inventory = new Inventory();
    }
}
