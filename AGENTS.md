# Codebase Guide for Agents

## Project Overview
This project is a suite of static HTML visualizations for the Merge Sort algorithm, designed for educational purposes.
It consists of:
1. `void-merge.html`: Micro-level visualization of the `merge()` function (pointer movements, comparisons).
2. `void-mergeSort.html`: Macro-level visualization of the `mergeSort()` recursion (call stack, divide & conquer).
3. `Main.java`: Reference implementation of the algorithm in Java.

## Development & Build Workflow

### Environment
- **Type**: Static HTML/CSS/JS.
- **Runtime**: Modern Web Browser (Chrome, Firefox, Safari, Edge).
- **Dependencies**: None (Zero-dependency).
- **Build Tools**: None. No `npm`, `webpack`, or `javac` required for the HTML files.

### Commands
Since this is a static project, "commands" are manual actions or simple checks.

- **Run/Preview**:
  - Open the `.html` file directly in a browser.
  - OR use a local server: `python3 -m http.server 8000` and navigate to `http://localhost:8000/void-merge.html`.

- **Lint (Manual)**:
  - Check browser console for errors.
  - Ensure no `eslint` or `prettier` config is violated (implicit standard).

- **Test**:
  - **Manual Verification**:
    1. Open the file.
    2. Click "Next Step" until the end.
    3. Click "Previous Step" back to start.
    4. Verify:
       - Visual elements (arrays, pointers) align correctly.
       - Log text matches the visual action.
       - Logic follows the standard Merge Sort algorithm.
       - No console errors appear during navigation.

## Code Structure & Architecture

### Single-File Rule
**CRITICAL**: Keep HTML, CSS, and JavaScript in a **SINGLE FILE**.
- Do NOT split into `.css` or `.js` files.
- Structure:
  ```html
  <!DOCTYPE html>
  <html>
  <head>
      <style>/* CSS here */</style>
  </head>
  <body>
      <!-- HTML Layout -->
      <script>
          // JS Logic
      </script>
  </body>
  </html>
  ```

### State-Driven Architecture
The visualization is **stateless logic** over **stateful data**.
1. **`steps` Array**: The core data structure. A pre-calculated (or hardcoded) array of state objects.
   - Each state object contains *everything* needed to render that frame (array contents, pointer indices, active lines of code, log message).
   - *Example Step Object*:
     ```javascript
     {
         text: "Comparing 3 and 5...",
         arr: [3, 5, 9],
         i: 0, j: 1, // Pointers
         lines: ['line-if'] // Highlighted code line ID
     }
     ```
2. **`render()` Function**: Pure function (mostly).
   - Reads `steps[currentStep]`.
   - Clears DOM containers.
   - Re-generates HTML strings for arrays/pointers based on the state.
   - Updates CSS classes for highlighting.
3. **Control Logic**:
   - `nextStep()` / `prevStep()`: Simply increment/decrement `currentStep` and call `render()`.

## Code Style Guidelines

### General
- **Indentation**: 4 spaces.
- **Language**: 
  - **Code/Comments**: English (mostly) or Mixed.
  - **UI/Content**: **Simplified Chinese (zh-CN)**. This is an educational tool for Chinese speakers.
- **Formatting**:
  - Keep lines under 120 characters where possible.
  - Use template literals (`` ` ``) for HTML string generation.

### HTML & CSS
- **Class Naming**: `kebab-case` (e.g., `.viz-panel`, `.stack-frame`).
- **Layout**: Flexbox is preferred for centering and alignment.
- **Color Palette**: GitHub-inspired (Clean, Professional).
  - Blue: `#0366d6` (Primary/Info)
  - Red: `#d73a49` (Danger/Pointer i)
  - Green: `#28a745` (Success/Pointer k)
  - Gray: `#f6f8fa` (Backgrounds)
- **Positioning**: 
  - Use `relative` for containers and `absolute` for pointers/overlays.
  - Use `getBoundingClientRect()` in JS for precise alignment of overlays (like brackets or connecting lines) rather than hardcoded pixel offsets.

### JavaScript
- **Naming Conventions**:
  - Variables/Functions: `camelCase` (e.g., `createCells`, `alignPointer`).
  - Constants: `UPPER_CASE` for config (e.g., `EMPTY`, `GHOST`) or `Pascal_Snake` for initial data (`Arr_init`).
  - DOM References: prefix with element type if helpful, or use IDs matching CSS (e.g., `btn-next`).
- **Logic**:
  - **Immutability**: Prefer creating new array states in `steps` rather than mutating a shared global array (though deep cloning is not strictly enforced, be careful).
  - **DOM Manipulation**: Use `innerHTML` reconstruction for simplicity in this specific project type. Performance is not a concern for < 100 elements.

## Modification Rules for Agents

1. **Preserve the Pattern**: 
   - If adding a feature, ask: "Can this be represented as a property in the `steps` object?"
   - If yes, add the property to the data and handle it in `render()`.
   - Do NOT add ad-hoc `document.getElementById(...).style...` calls inside event listeners.

2. **Visual Consistency**:
   - Reuse `.cell`, `.arrow`, `.code-line` classes.
   - If creating new visual elements (e.g., a tree view), follow the existing color scheme.

3. **Content**:
   - Ensure all user-facing explanations are in **Simplified Chinese**.
   - Keep technical terms (Start, End, Mid, Merge) in English if it helps clarity, or use standard translations.

4. **Safety**:
   - Always check bounds: `if (currentStep < steps.length - 1)`.
   - Handle null/undefined in `render()` for optional state properties (e.g., `state.scope` might be null).

## Common Snippets

### Step Navigation
```javascript
function nextStep() {
    if (currentStep < steps.length - 1) { 
        currentStep++; 
        render(); 
    }
}
```

### Cell Generation
```javascript
// Use map to generate HTML string
container.innerHTML = data.map((val, idx) => `
    <div class="cell-wrapper">
        <div class="cell ${val === EMPTY ? 'cell-empty' : ''}">${val}</div>
        <div class="index">${idx}</div>
    </div>
`).join('');
```

## Java (Reference)
- The `Main.java` file is the **source of truth** for the algorithm's logic.
- If the visualization behavior deviates from `Main.java`, the visualization is likely wrong (unless it's a specific simplification for teaching).
