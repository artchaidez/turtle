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
    post: jest.fn()
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
    test("Posts restock API correctly", async () => {

        });
})