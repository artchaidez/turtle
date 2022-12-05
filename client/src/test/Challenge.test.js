import { render, screen, cleanup } from '@testing-library/react';
import Challenge from "../components/Challenge";
import axios from "axios";
import React, { useState } from "react";
import "@testing-library/jest-dom";

// NOTE: run 'npm test' in bash
// NOTE: 'npm test' now runs in C:\Users\artch\IdeaProjects\turtle\client
// node_modules/.bin/cypress open

jest.mock("axios", () => ({
    ...jest.requireActual("axios"),
    post: jest.fn(),
}));

afterEach(() =>{
    cleanup();
});

describe("Challenge tests", () => {
    it("Should find Challenge Buttons on screen", () => {
        render(<Challenge />);

        const lowStockButton = screen.getByRole('button', { name: "Get Low-Stock Items" });
        const reOrderCost = screen.getByRole('button', { name: "Determine Re-Order Cost" });

        expect(lowStockButton).toBeInTheDocument();
        expect(reOrderCost).toBeInTheDocument();

    });

    // TODO: test useState and handle: ClickLowStock
    test("Get low stock API correctly", async () => {

    });

    // https://www.youtube.com/watch?v=5nzoYEjvgRc
    // TODO: test useState handle: ClickReorderCost
    // npm test Challenge -t "Posts restock API correctly"
    test.only("Posts restock API correctly", async () => {

        // need to call handleClickReorderCost
        //lowStock.data
        // then calls setRestockCost(data.data);

        // toHaveBeenCalledWith(url, data to get back)
        /** name: "Good & Plenty",stock:4,capacity:20,cost:16,id:786123,
                     name:"Twix",stock:17,capacity:70,cost:53,id:627791,
                     name:"Starburst",stock:8,capacity:45,cost:37,id:506709,
                     name:"Butterfinger",stock:10, capacity:60,cost:50,id:601091,
                     name:"Sour Patch Kids",stock:14,capacity:60,cost:46,id:520745, */
        //axios.post
        /*expect(axios.post).toHaveBeenCalledWith("http://localhost:4567/restock-cost",
         expect.objectContaining({
         "capacity": 60, "cost": 46, "id": 520745, "name": "Sour Patch Kids", "stock": 14
         })
         );*/
    });
})