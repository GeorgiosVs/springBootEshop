# City Operations Flow Diagram

This document provides flow diagrams for the city operations in the Spring Boot e-shop application, highlighting the improvements made to the codebase.

## Components Overview

```
┌─────────────────┐     ┌─────────────────┐     ┌─────────────────┐     ┌─────────────────┐
│                 │     │                 │     │                 │     │                 │
│  CityController │────▶│   CityService   │────▶│ CityRepository  │────▶│  Database       │
│                 │     │                 │     │                 │     │                 │
└─────────────────┘     └─────────────────┘     └─────────────────┘     └─────────────────┘
        ▲                       ▲                       ▲
        │                       │                       │
        │                       │                       │
        ▼                       ▼                       ▼
┌─────────────────┐     ┌─────────────────┐     ┌─────────────────┐
│                 │     │                 │     │                 │
│     CityDto     │     │      City       │     │      City       │
│                 │     │     Entity      │     │     Entity      │
└─────────────────┘     └─────────────────┘     └─────────────────┘
```

## Improvements Made

### 1. CityController
- Standardized error handling across all endpoints
- Removed commented-out code
- Added proper documentation
- Improved response handling with ResponseEntity

### 2. CityService
- Extracted repeated validation logic into a separate method
- Improved DTO conversion with a dedicated method
- Fixed bug in updateCity method (now using cityId parameter correctly)
- Added proper null checks and error messages

### 3. CityRepository
- Improved naming (entityMgr → entityManager)
- Optimized query execution
- Added comprehensive documentation
- Used proper return types

### 4. City and CityDto Classes
- Added getters and setters while maintaining public field access
- Added proper constructors
- Added documentation

## Detailed Flow Diagrams

### 1. Get All Cities Flow

```
┌─────────────────┐     ┌─────────────────┐     ┌─────────────────┐     ┌─────────────────┐
│  CityController │     │   CityService   │     │ CityRepository  │     │  Database       │
│                 │     │                 │     │                 │     │                 │
│  getAllCities() │────▶│   getCities()   │────▶│     get()       │────▶│  SELECT query   │
│                 │     │                 │     │                 │     │                 │
└─────────────────┘     └─────────────────┘     └─────────────────┘     └─────────────────┘
        │                       │                       │                       │
        │                       │                       │                       │
        │                       │                       │                       │
        │                       │                       ▼                       │
        │                       │               ┌─────────────────┐             │
        │                       │               │  List<City>     │◀────────────┘
        │                       │               │                 │
        │                       │               └─────────────────┘
        │                       │                       │
        │                       │                       │
        │                       ▼                       │
        │               ┌─────────────────┐             │
        │               │ convertToDto()   │◀────────────┘
        │               │ for each City    │
        │               └─────────────────┘
        │                       │
        │                       │
        │                       ▼
        │               ┌─────────────────┐
        │               │  List<CityDto>  │
        │               │                 │
        │               └─────────────────┘
        │                       │
        ▼                       │
┌─────────────────┐             │
│ ResponseEntity  │◀────────────┘
│ with CityDto    │
│ list or error   │
└─────────────────┘
```

### 2. Create City Flow

```
┌─────────────────┐     ┌─────────────────┐     ┌─────────────────┐     ┌─────────────────┐
│  CityController │     │   CityService   │     │ CityRepository  │     │  Database       │
│                 │     │                 │     │                 │     │                 │
│  createCity()   │────▶│  createCity()   │     │                 │     │                 │
│                 │     │                 │     │                 │     │                 │
└─────────────────┘     └─────────────────┘     └─────────────────┘     └─────────────────┘
        │                       │                       │                       │
        │                       ▼                       │                       │
        │               ┌─────────────────┐             │                       │
        │               │  validateDto()  │             │                       │
        │               │                 │             │                       │
        │               └─────────────────┘             │                       │
        │                       │                       │                       │
        │                       ▼                       │                       │
        │               ┌─────────────────┐             │                       │
        │               │  Create City    │             │                       │
        │               │  entity         │             │                       │
        │               └─────────────────┘             │                       │
        │                       │                       │                       │
        │                       │                       │                       │
        │                       ▼                       │                       │
        │               ┌─────────────────┐             │                       │
        │               │  cityRepository │────────────▶│     create()     │────▶│  INSERT query   │
        │               │  .create()      │             │                 │     │                 │
        │               └─────────────────┘             └─────────────────┘     └─────────────────┘
        │                       │                                                       │
        │                       │                                                       │
        │                       ▼                                                       │
        │               ┌─────────────────┐                                             │
        │               │  Return city ID │◀────────────────────────────────────────────┘
        │               │                 │
        │               └─────────────────┘
        │                       │
        ▼                       │
┌─────────────────┐             │
│ ResponseEntity  │◀────────────┘
│ with ID or      │
│ error message   │
└─────────────────┘
```

### 3. Update City Flow

```
┌─────────────────┐     ┌─────────────────┐     ┌─────────────────┐     ┌─────────────────┐
│  CityController │     │   CityService   │     │ CityRepository  │     │  Database       │
│                 │     │                 │     │                 │     │                 │
│  updateCity()   │────▶│  updateCity()   │     │                 │     │                 │
│                 │     │                 │     │                 │     │                 │
└─────────────────┘     └─────────────────┘     └─────────────────┘     └─────────────────┘
        │                       │                       │                       │
        │                       ▼                       │                       │
        │               ┌─────────────────┐             │                       │
        │               │  validateDto()  │             │                       │
        │               │                 │             │                       │
        │               └─────────────────┘             │                       │
        │                       │                       │                       │
        │                       ▼                       │                       │
        │               ┌─────────────────┐             │                       │
        │               │ cityRepository  │────────────▶│    getById()     │────▶│  SELECT query   │
        │               │ .getById()      │             │                 │     │                 │
        │               └─────────────────┘             └─────────────────┘     └─────────────────┘
        │                       │                                                       │
        │                       ▼                                                       │
        │               ┌─────────────────┐                                             │
        │               │ Check if city   │◀────────────────────────────────────────────┘
        │               │ exists          │
        │               └─────────────────┘
        │                       │
        │                       ▼
        │               ┌─────────────────┐
        │               │  Create City    │
        │               │  entity with    │
        │               │  cityId (fixed) │
        │               └─────────────────┘
        │                       │
        │                       ▼
        │               ┌─────────────────┐             ┌─────────────────┐     ┌─────────────────┐
        │               │  cityRepository │────────────▶│    update()     │────▶│  UPDATE query   │
        │               │  .update()      │             │                 │     │                 │
        │               └─────────────────┘             └─────────────────┘     └─────────────────┘
        │                       │                                                       │
        │                       ▼                                                       │
        │               ┌─────────────────┐                                             │
        │               │ Update DTO ID   │◀────────────────────────────────────────────┘
        │               │ to match cityId │
        │               └─────────────────┘
        │                       │
        │                       ▼
        │               ┌─────────────────┐
        │               │ Return updated  │
        │               │ CityDto         │
        │               └─────────────────┘
        │                       │
        ▼                       │
┌─────────────────┐             │
│ ResponseEntity  │◀────────────┘
│ with updated    │
│ CityDto or error│
└─────────────────┘
```

### 4. Delete City Flow

```
┌─────────────────┐     ┌─────────────────┐     ┌─────────────────┐     ┌─────────────────┐
│  CityController │     │   CityService   │     │ CityRepository  │     │  Database       │
│                 │     │                 │     │                 │     │                 │
│  deleteCity()   │────▶│  deleteCity()   │     │                 │     │                 │
│                 │     │                 │     │                 │     │                 │
└─────────────────┘     └─────────────────┘     └─────────────────┘     └─────────────────┘
        │                       │                       │                       │
        │                       ▼                       │                       │
        │               ┌─────────────────┐             │                       │
        │               │ cityRepository  │────────────▶│    getById()     │────▶│  SELECT query   │
        │               │ .getById()      │             │                 │     │                 │
        │               └─────────────────┘             └─────────────────┘     └─────────────────┘
        │                       │                                                       │
        │                       ▼                                                       │
        │               ┌─────────────────┐                                             │
        │               │ Check if city   │◀────────────────────────────────────────────┘
        │               │ exists          │
        │               └─────────────────┘
        │                       │
        │                       ▼
        │               ┌─────────────────┐             ┌─────────────────┐     ┌─────────────────┐
        │               │  cityRepository │────────────▶│    delete()     │────▶│  DELETE query   │
        │               │  .delete()      │             │                 │     │                 │
        │               └─────────────────┘             └─────────────────┘     └─────────────────┘
        │                       │                                                       │
        │                       ▼                                                       │
        │               ┌─────────────────┐                                             │
        │               │  convertToDto() │◀────────────────────────────────────────────┘
        │               │                 │
        │               └─────────────────┘
        │                       │
        │                       ▼
        │               ┌─────────────────┐
        │               │ Return deleted  │
        │               │ CityDto         │
        │               └─────────────────┘
        │                       │
        ▼                       │
┌─────────────────┐             │
│ ResponseEntity  │◀────────────┘
│ with deleted    │
│ CityDto or error│
└─────────────────┘
```

## Key Improvements in the Flow

1. **Consistent Error Handling**: All operations now have standardized error handling with proper error messages.
2. **Validation Extraction**: The validation logic has been extracted to a separate method to avoid code duplication.
3. **DTO Conversion**: A dedicated method for converting entities to DTOs improves code maintainability.
4. **Proper ID Handling**: The updateCity method now correctly uses the path variable ID instead of the DTO ID.
5. **Null Checks**: Added proper null checks when retrieving entities to prevent null pointer exceptions.
6. **Documentation**: All components now have comprehensive documentation.
7. **Improved Repository Methods**: Repository methods have been optimized and properly named.