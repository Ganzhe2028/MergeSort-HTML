# Merge Sort Visualization (归并排序可视化)

A suite of static HTML educational tools designed to visualize the Merge Sort algorithm from both macro and micro perspectives. Built for AP CSA students and algorithm learners.

![Project Preview](https://img.shields.io/badge/Status-Active-success)
![Language](https://img.shields.io/badge/Language-HTML%2FJS-orange)
![Content](https://img.shields.io/badge/Content-Simplified_Chinese-blue)

## 🌟 Features

This project breaks down Merge Sort into two distinct visualizations to isolate complexity:

### 1. Macro View: Recursion Panorama (宏观视角)
- **File**: `void-mergeSort.html`
- **Focus**: The "Divide" phase and the structure of recursion.
- **Visuals**: Shows the call stack, the recursion tree, and how the array is split `[L...mid]` and `[mid+1...R]` until base cases are reached.

### 2. Micro View: Two-Pointer Merge (微观视角)
- **File**: `void-merge.html`
- **Focus**: The "Conquer" phase (the `merge` function).
- **Visuals**: Detailed step-by-step animation of the `i`, `j`, and `k` pointers comparing elements from temporary left/right arrays and overwriting the original array.

## 🚀 Getting Started

Since this is a static project, no installation or build tools are required.

1. **Clone the repository**
   ```bash
   git clone https://github.com/Ganzhe2028/MergeSort-HTML.git
   ```

2. **Run the visualization**
   - Simply navigate to the folder and double-click `index.html` to open it in your web browser.
   - Or run a simple local server:
     ```bash
     python3 -m http.server 8000
     # Then open http://localhost:8000
     ```

## 📂 Project Structure

```
MergeSort-HTML/
├── index.html            # Landing page with navigation
├── void-mergeSort.html   # Macro-level recursion visualization
├── void-merge.html       # Micro-level merge logic visualization
├── Main.java             # Reference Java implementation
└── AGENTS.md             # Development guide for AI contributors
```

## 🛠 Tech Stack

- **HTML5 / CSS3**: For layout and styling (GitHub-inspired design).
- **Vanilla JavaScript**: For logic and state management.
- **Zero Dependencies**: No `npm`, `webpack`, or libraries required.

## 🤝 Contributing

Contributions are welcome! Please read [AGENTS.md](AGENTS.md) for our coding standards and architectural guidelines (e.g., Single-File Rule, State-Driven Architecture).

## 📄 License

Open source for educational use.
