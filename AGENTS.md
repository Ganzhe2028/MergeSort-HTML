# Codebase Guide for Agents

## Project Overview
This project is a suite of static HTML visualizations for the Merge Sort algorithm, designed for AP CSA students.
It consists of:
1. `void-merge.html`: Micro-level visualization of the `merge()` function (pointer movements, comparisons).
2. `void-mergeSort.html`: Macro-level visualization of the `mergeSort()` recursion (call stack, divide & conquer).
3. `index.html`: The landing page connecting the tools.
4. `Main.java`: Reference implementation (Source of Truth).

## Development & Build Workflow

### Environment
- **Type**: Static HTML/CSS/JS.
- **Runtime**: Modern Web Browser (Chrome, Firefox, Safari, Edge).
- **Dependencies**: None (Zero-dependency).
- **Build Tools**: None. No `npm`, `webpack`, or `javac` required for HTML files.

### Commands

**1. Run/Preview (Local Server)**
Since strict pathing can be an issue with file:// protocol, use a Python simple server:
```bash
# Run this in the project root
python3 -m http.server 8000
# Access: http://localhost:8000
```

**2. Linting (Manual)**
- **Console Check**: Open DevTools > Console. Ensure 0 errors on load and during navigation.
- **Visual Check**: Ensure flexbox layouts don't break on window resize (`window.addEventListener('resize', render)` is required).

**3. Testing (Manual Verification)**
To "run a test", perform this sequence:
1. Open the target file (e.g., `void-merge.html`).
2. **Forward Test**: Click "Next Step" (or ArrowRight) until the end.
   - *Expectation*: Steps progress logically, log text updates, pointers move, "Next" disables at end.
3. **Backward Test**: Click "Previous Step" (or ArrowLeft) back to start.
   - *Expectation*: State restores perfectly, "Prev" disables at start.
4. **Logic Check**: Compare visualization against `Main.java` logic.

## Code Structure & Architecture

### Single-File Rule
**CRITICAL**: Keep HTML, CSS, and JavaScript in a **SINGLE FILE**.
- Structure:
  ```html
  <!DOCTYPE html>
  <html lang="zh-CN">
  <head>
      <style>/* CSS here */</style>
  </head>
  <body>
      <!-- Layout -->
      <script>
          // JS Logic
      </script>
  </body>
  </html>
  ```

### State-Driven Architecture
The visualization is **stateless logic** over **stateful data**.
1. **`steps` Array**: A pre-calculated array of state objects.
   - Contains *snapshot* of all data: `arr`, `i`, `j`, `k`, `text`, `activeLines`.
   - *Immutability*: Prefer new array instances in steps over mutating shared arrays.
2. **`render()` Function**: Pure function.
   - Reads `steps[currentStep]`.
   - Clears DOM (`innerHTML`).
   - Re-generates HTML strings for arrays/pointers.
   - Updates CSS classes.
3. **Navigation**: `currentStep` index + `render()` call.

## Code Style Guidelines

### General
- **Indentation**: 4 spaces.
- **Language**:
  - **Code/Comments**: English or Mixed.
  - **UI/Content**: **Simplified Chinese (zh-CN)**.
- **Formatting**: Keep lines under 120 chars. Use template literals (`` ` ``).

### HTML & CSS
- **Class Naming**: `kebab-case` (e.g., `.viz-panel`, `.stack-frame`).
- **Colors**:
  - Blue: `#0366d6` (Primary), Red: `#d73a49` (Pointer i), Green: `#28a745` (Pointer k).
- **Positioning**: Use `absolute` for pointers inside `relative` containers. Use `getBoundingClientRect()` for precise alignment.

### JavaScript
- **Naming**: `camelCase` (vars/funcs), `UPPER_CASE` (constants), `PascalCase` (Classes/InitData).
- **Constants**:
  ```javascript
  const EMPTY = 'EMPTY'; // Placeholder for uninitialized cell
  const GHOST = null;    // Placeholder for hidden/ghost cell
  ```
- **DOM**: Use `document.getElementById` and `innerHTML` reconstruction.
- **Safety**: Always check bounds `if (currentStep < steps.length - 1)`.

## Modification Rules for Agents

1. **Preserve the Pattern**:
   - Do NOT add stateful variables outside `steps` (except `currentStep`).
   - All visual changes must be derived from `steps[currentStep]`.

2. **Visual Consistency**:
   - Reuse `.cell`, `.arrow`, `.code-line`.
   - Pointer colors must match: i=Red, j=Blue, k=Green (or context equivalent).

3. **Content**:
   - Explanations must be educational.
   - Use `<b>Bold</b>` for key terms in log text.

4. **Reference Implementation**:
   - `Main.java` is the Source of Truth.
   - If `Main.java` says `i++`, the viz must show `i` moving.

## Agent Behavior Rules (Cursor/Copilot)

- **Planning**: Before writing code, analyze `steps` array structure.
- **Editing**: When modifying `steps`, ensure previous/next steps maintain logical continuity.
- **Debugging**: If pointers misalign, check `alignPointer()` calculation or CSS `width` of cells (usually 56px).
- **No External Libs**: Do not import jQuery, React, or Bootstrap. Use Vanilla JS/CSS.
