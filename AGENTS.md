# Codebase Guide for Agents

## Project Overview
This project is a single-file static HTML application visualizing the Merge Sort algorithm. It includes HTML structure, CSS styling, and JavaScript logic within `1.html`.

## Development & Build
- **Environment**: Browser-based static HTML. No Node.js, npm, or build tools required.
- **Run**: Open `1.html` directly in a modern web browser.
- **Test**: Manual verification by clicking "Next Step" / "Previous Step" buttons to ensure visualization matches the algorithm logic.
- **Dependencies**: None. Pure Vanilla JS/CSS.

## Code Structure
- **File**: `1.html` contains everything.
- **Sections**:
  1. `<style>`: CSS for layout (Flexbox) and visualization components (arrays, pointers, cells).
  2. `<body>`: HTML structure for the visualization panel, log box, array containers, and code display.
  3. `<script>`: Logic for state management and rendering.

## Architecture Pattern
- **State-Driven Visualization**: The application uses a `steps` array where each object represents a snapshot of the algorithm's state (array contents, pointer positions, messages).
- **Rendering**: The `render()` function clears and rebuilds the DOM for array cells based on the `currentStep` state.
- **Data Model**:
  - `L`, `R`, `arr`: Arrays representing the left, right temp arrays and the main array.
  - `EMPTY`: Placeholder for initialized but empty cells.
  - `GHOST`: Placeholder for non-existent/ghost cells.

## Code Style Guidelines

### General
- **Indentation**: 4 spaces.
- **Language**: English for code/variables, **Chinese (Simplified)** for comments and UI text (logs, button labels).

### HTML & CSS
- **Class Naming**: kebab-case (e.g., `.main-wrapper`, `.viz-panel`).
- **Colors**: GitHub-inspired palette (e.g., `#0366d6` blue, `#d73a49` red, `#28a745` green).
- **Layout**: Heavy use of Flexbox (`display: flex`).

### JavaScript
- **Syntax**: ES6+ (const/let, arrow functions, template literals).
- **Semicolons**: Always used.
- **Naming Conventions**:
  - Variables/Functions: camelCase (`currentStep`, `createCells`).
  - Constants: UPPER_CASE (`EMPTY`, `GHOST`) or Pascal_Snake (`Arr_init`).
  - DOM IDs: kebab-case (`log-text`, `btn-next`).
- **Logic Flow**:
  1. Define `steps` data.
  2. Implement helper functions (`createCells`, `alignPointer`).
  3. `render()` function applies state to DOM.
  4. Event listeners for interactive controls.

## Error Handling
- Since this is a static visualization, strict error handling is minimal.
- Ensure `document.getElementById` returns elements before manipulating (optional but good practice).
- Boundary checks on `currentStep` in `nextStep()` and `prevStep()`.

## Modification Rules
1. **Preserve Single-File Structure**: Do not split into .css or .js files unless explicitly requested.
2. **Maintain State Pattern**: When adding new algorithm steps, add them to the `steps` array rather than manipulating DOM directly in event handlers.
3. **Keep UI Consistent**: Reuse existing CSS classes (`.cell`, `.arrow`, `.code-line`) to maintain visual consistency.
