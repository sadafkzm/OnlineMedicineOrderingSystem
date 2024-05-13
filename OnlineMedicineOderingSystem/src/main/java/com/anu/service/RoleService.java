package com.anu.service;

import com.anu.model.Role;

public interface RoleService {
    Role findByName(String name);
}
