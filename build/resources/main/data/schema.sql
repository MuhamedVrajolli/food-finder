/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  medi
 * Created: May 7, 2020
 */
CREATE DATABASE food_finder;

USING food_finder;
CREATE TABLE price_categories (
    id BIGSERIAL PRIMARY KEY,
    category VARCHAR(50) NOT NULL,
    created_date TIMESTAMP DEFAULT current_timestamp,
    is_active BOOLEAN DEFAULT TRUE
);

CREATE TABLE foods (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    preparation_time INT NOT NULL, --in minutes
    price_category BIGINT REFERENCES price_categories(id) NOT NULL,
    is_dessert BOOLEAN NOT NULL,
    created_date TIMESTAMP DEFAULT current_timestamp,
    is_active BOOLEAN DEFAULT TRUE
);

