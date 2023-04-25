# Automated accessibility tests kit (AATK)

## Adequate Color Contrast Ratio (`TestAdequateContrastRatio`)

*Accessibility issue:* contraste de texto e/ou imagem insuficiente

*Accessibility requirement:* deve-se utilizar uma taxa de contraste de ao menos 4.5:1

*Target widgets:* `Button`, `ImageButton`, `ImageView`


## Focus Based Navigation Support (`TestFocusBasedNavigationSuport`)

*Accessibility issue:* interação e/ou navegação confusa

*Accessibility requirement:* aplicativo deve suportar navegação baseada em foco

*Target widgets:* any `AccessibilityNodeInfo`


## Interaction Element Spacing (`TestInteractionElementSpacing`)

*Accessibility issue:* falta de espaçamento suficiente entre os elementos

*Accessibility requirement:* Componentes de interação devem ter um espaçamento mínimo de 8dp entre si e das bordas da tela


## Form Control Label (`TestMustFormControlHaveLabel`)

*Accessibility issue:* falta de rótulo no componente

*Accessibility requirement:* para cada controle de formulário, deve existir um TextView com o atributo labelFor associado, ou deve ter o atributo hint fornecido

*Target widgets:* `EditText`, `CheckBox`, `RadioButton`, `Switch`


## Non-textual Content Alternative Text (`TestMustHaveAlternativeText`)

*Accessibility issue:* imagens e/ou ícones sem alternativa textual

*Accessibility requirement:* todo conteúdo não textual, como imagens e conteúdo de mídia, deve possuir descrição alternativa em  texto, explicando o conteúdo e/ou propósito do elemento

*Target widgets:* `ImageButton`, `ImageView`


## Touch Target Size (`TestTouchTargetSize`)

*Accessibility issue:* tamanho do alvo de touch inadequado

*Accessibility requirement:* alvo de toque deve ter pelo menos 48x48

*Target widgets:* `Button`, `ImageButton`
