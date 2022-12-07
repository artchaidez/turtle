import { render, screen, cleanup } from '@testing-library/react';
import App from "../components/Challenge";
import React, { useState } from "react";
import "@testing-library/jest-dom";

afterEach(() =>{
    cleanup();
});

describe("Challenge tests", () => {
    test("Should find Challenge Buttons on screen", () => {
        render(<App />);

        const lowStockButton = screen.getByRole('button', { name: "Get Low-Stock Items" });
        const reOrderCost = screen.getByRole('button', { name: "Determine Re-Order Cost" });

        expect(lowStockButton).toBeInTheDocument();
        expect(reOrderCost).toBeInTheDocument();
    });

})