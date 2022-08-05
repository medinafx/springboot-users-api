package com.nisum.users.controller;

public class NotFoundException extends RuntimeException
{
    public NotFoundException(Integer id) {
        super("Could not find the resource " + id);
    }
}
