Simple game based on CRUD Java Spring Boot application. 
You can create a hero and send him to fight in the arena
You can upgreat hero's skills
if the fight ends with ten victories in a row you become the champion

1. **Create a new hero:**
- POST request: `/new/{name}`
- Creates a new hero with the provided name.

2. **Start a hero's fight:**
- PATCH request: `/getFight/{id}`
- Initiates a fight for the hero with the specified ID.

3. **Upgrade hero's attack:**
- PATCH request: `/upgreatAttack/{id}`
- Upgrades the attack of the hero with the specified ID.

4. **Upgrade hero's defence:**
- PATCH request: `/upgreatDefence/{id}`
- Upgrades the defence of the hero with the specified ID.
