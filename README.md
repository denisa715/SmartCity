This project represents a simplified software system for monitoring and managing various aspects of a smart city. The system records data, displays statistics, and performs basic calculations to optimize city resources.

📝 General Description

The application covers five main areas of urban infrastructure:

Intersection Traffic

Parking Spaces

Public Transport

Utility Consumption (water, energy)

Waste Collection

✨ Main Features (Functional Requirements)

🚦 Traffic & Traffic Lights: Keeps records of intersections, allows manual updates for traffic light timings (red/green), and displays intersection information.

🅿️ Parking: Logs vehicle entries/exits, calculates occupancy rates, and flags overcrowded parking lots (e.g., occupancy > 80%).

🚌 Public Transport: Keeps records of bus lines (stops, travel times) and provides simple arrival time estimations.

⚡ Utilities (Water & Energy): Monitors monthly readings for various consumption points, compares consumption between months, and flags unusual usage (e.g., increases over 50%).

♻️ Waste Collection: Monitors container fill levels, triggers alerts when thresholds are exceeded (e.g., > 75%), and calculates distances for collection routes.

📊 Reports: Generates lists of monitored entities and summary statistics (e.g., average parking occupancy rate, total monthly consumption).

🛠 Technical Details

The project is developed using Object-Oriented Programming (OOP) concepts, based on the following architecture:

Base Classes: Intersectie (Intersection), Parcare (Parking), LinieAutobuz (Bus Line), PunctConsum (Consumption Point), ContainerDeseuri (Waste Container).

Interfaces: Implementation of the Monitorizabil interface with the genereazaRaportScurt() method across various entities.

Collections: Utilizes ArrayList for the efficient storage and management of all entities.

Sorting (Comparable / Comparator):

Sorting parking lots by their occupancy rate (Comparable<Parcare>).

Sorting bus lines by total travel time to find the fastest routes (Comparator).

Exception Handling: Defines and uses custom exceptions to ensure application robustness:

EntitateInexistentaException (triggered when an entity is not found).

ValoareInvalidaException (triggered by incorrect values, e.g., fill level > 100%, negative times).

🧮 Implemented Calculation Examples

Parking occupancy rate: (Occupied spaces / Total capacity) * 100

Utility consumption increase: The difference between consecutive months.

Waste route total distance: The sum of distance segments between visited containers on a given route
