import { SpBootNg4Page } from './app.po';

describe('sp-boot-ng4 App', () => {
  let page: SpBootNg4Page;

  beforeEach(() => {
    page = new SpBootNg4Page();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
